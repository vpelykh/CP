window.onload = function() {
  // Отримуємо посилання на елементи сторінки за допомогою їх ідентифікаторів
  var button = document.getElementById("myButton");
  var text = document.getElementById("myText");
  // Додаємо обробник події для кнопки
  button.addEventListener("click", function() {
    // Змінюємо текстове поле при натисканні кнопки
    text.innerHTML = "Ви натиснули кнопку!";
  });
};
