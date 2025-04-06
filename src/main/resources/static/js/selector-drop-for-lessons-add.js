// Вариант 1
document.addEventListener("DOMContentLoaded", function() {
    // Получаем элементы select для дисциплины и преподавателя
    const disciplineSelect = document.getElementById('disciplineCode');
    const professorSelect = document.getElementById('professorPersonnelNumber');

    // Сбрасываем выбранные значения
    disciplineSelect.selectedIndex = 0; // Первое поле дисциплины
    professorSelect.selectedIndex = 0; // Первое поле преподавателя
});

// Вариант 2
// window.onload = function() {
//     document.getElementById("disciplineCode").selectedIndex = 0;  // Сбрасываем выбор дисциплины
//     document.getElementById("professorPersonnelNumber").selectedIndex = 0;  // Сбрасываем выбор преподавателя
// }