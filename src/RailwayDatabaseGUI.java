import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class RailwayDatabaseGUI extends JFrame {

    private final String DATABASE_URL = "jdbc:mysql://localhost:3306/railway";
    private final String DATABASE_USERNAME = "root";
    private final String DATABASE_PASSWORD = "password";

    private final String[] RAILWAY_NAMES = {"Poltava Kyivska railway station","Poltava-South Railway station"};

    private JPanel contentPane;
    private JComboBox<String> railwayComboBox;
    private JTextField tripNameField;
    private JTextField ticketNameField;
    private JTextField passengerNameField;
    private JTextField trainNameField;
    private JTextField railwayHeadNameField;
    private JButton insertTripButton;
    private JButton insertRailwayHead;
    private JButton insertTrainButton;
    private JButton insertPassengerButton;
    private JButton insertTicketButton;
    private JButton searchButton;
    private JTextArea searchResultsArea;

    private Connection connection;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RailwayDatabaseGUI frame = new RailwayDatabaseGUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public RailwayDatabaseGUI() throws SQLException {
        connectToDatabase();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        setTitle("Railway Database");

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new GridLayout(5, 2, 5, 5));
        setContentPane(contentPane);

        railwayComboBox = new JComboBox<>(RAILWAY_NAMES);
        contentPane.add(new JLabel("Railway"));
        contentPane.add(railwayComboBox);

        tripNameField = new JTextField();
        contentPane.add(new JLabel("Trip Name"));
        contentPane.add(tripNameField);

        ticketNameField = new JTextField();
        contentPane.add(new JLabel("Ticket Name"));
        contentPane.add(ticketNameField);

        passengerNameField = new JTextField();
        contentPane.add(new JLabel("Passenger Name"));
        contentPane.add(passengerNameField);

        trainNameField = new JTextField();
        contentPane.add(new JLabel("Train Name"));
        contentPane.add(trainNameField);

        railwayHeadNameField = new JTextField();
        contentPane.add(new JLabel("Railway Head Name"));
        contentPane.add(railwayHeadNameField);

        insertRailwayHead = new JButton("Insert Railway Head");
        insertRailwayHead.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    insertRailwayHead();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        contentPane.add(insertRailwayHead);

        insertTrainButton = new JButton("Insert Train");
        insertTrainButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    insertTrain();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        contentPane.add(insertTrainButton);

        insertTripButton = new JButton("Insert Trip");
        insertTripButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    insertTrip();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }});

        contentPane.add(insertTripButton);

        insertPassengerButton = new JButton("Insert Passenger");
        insertPassengerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    insertPassenger();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }});

        contentPane.add(insertPassengerButton);

        insertTicketButton = new JButton("Insert Ticket");
        insertTicketButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    insertTicket();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }});

        contentPane.add(insertTicketButton);

        searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            searchDatabase();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
        contentPane.add(searchButton);

        searchResultsArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(searchResultsArea);
        contentPane.add(scrollPane);

        connection.close();
    }

        private void connectToDatabase() throws SQLException {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        }

        private void insertTrip() throws SQLException {
            String tripName = tripNameField.getText();
            String trainName = trainNameField.getText();

            String query = "INSERT INTO trips (trip_name, train_name) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, tripName);
            statement.setString(2, trainName);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(contentPane, "Trip was inserted successfully!");
        }

        private void insertTrain() throws SQLException {
            String trainName = trainNameField.getText();

            String query = "INSERT INTO trains (train_name) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, trainName);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(contentPane, "Train was inserted successfully!");
        }

        private void insertPassenger() throws SQLException {
            String passengerName = passengerNameField.getText();

            String query = "INSERT INTO passengers (passenger_name) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, passengerName);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(contentPane, "Passenger was inserted successfully!");
        }

        private void insertTicket() throws SQLException {
            String passengerName = passengerNameField.getText();
            String ticketName = ticketNameField.getText();
            String tripName = tripNameField.getText();
            String railwayName = (String) railwayComboBox.getSelectedItem();

            String query = "INSERT INTO tickets (railway_name, ticket_name, passenger_name, trip_name) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, railwayName);
            statement.setString(2, ticketName);
            statement.setString(3, passengerName);
            statement.setString(4, tripName);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(contentPane, "Ticket was inserted successfully!");
        }

        private void insertRailwayHead() throws SQLException {
            String railwayHeadName = railwayHeadNameField.getText();
            String railwayName = (String) railwayComboBox.getSelectedItem();


            String query = "INSERT INTO railway_heads (railway_head_name, railway_name) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, railwayHeadName);
            statement.setString(2, railwayName);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(contentPane, "Railway's head was inserted successfully!");
        }

        private void searchDatabase() throws SQLException {
            String searchTerm = JOptionPane.showInputDialog(contentPane, "Enter search term:");
            String query = "SELECT * FROM trains WHERE train_name = ?" +
                    "UNION SELECT * FROM passengers WHERE passenger_name = ?" +
                    "UNION SELECT * FROM railway_heads WHERE railway_head_name = ? OR railway_name = ? " +
                    "UNION SELECT * FROM tickets WHERE railway_name = ? OR ticket_name = ? OR passenger_name = ? OR trip_name = ?" +
                    "UNION SELECT * FROM trips WHERE trip_name = ? OR train_name = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            for (int i = 1; i <= 8; i++) {
                statement.setString(i, searchTerm);
            }
            ResultSet resultSet = statement.executeQuery();
            StringBuilder searchResults = new StringBuilder();
            while (resultSet.next()) {
                String railwayName = resultSet.getString("railway_name");
                String trainName = resultSet.getString("train_name");
                String passengerName = resultSet.getString("passenger_name");
                String ticketName = resultSet.getString("ticket_name");
                String tripName = resultSet.getString("trip_name");
                String railwayHeadName = resultSet.getString("railway_head_name");

                if (railwayName != null) {
                    searchResults.append("Railway: ").append(railwayName).append("\n");
                }
                if (trainName != null) {
                    searchResults.append("Train: ").append(trainName).append("\n");
                }
                if (passengerName != null) {
                    searchResults.append("Passenger: ").append(passengerName).append("\n");
                }
                if (ticketName != null) {
                    searchResults.append("Ticket: ").append(ticketName).append("\n");
                }
                if (tripName != null) {
                    searchResults.append("Trip: ").append(tripName).append("\n");
                }
                if (railwayHeadName != null) {
                    searchResults.append("Railway's head: ").append(railwayHeadName).append("\n");
                }
                searchResults.append("\n");
            }
            searchResultsArea.setText(searchResults.toString());
        }
}
