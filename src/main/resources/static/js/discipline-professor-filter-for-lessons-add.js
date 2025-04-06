document.addEventListener("DOMContentLoaded", function () {

    const disciplineSelect = document.getElementById('disciplineCode');
    const professorSelect = document.getElementById('professorPersonnelNumber');

    // Хелпер для перерисовки select
    function updateSelectOptions(select, options, valueKey, textCallback) {
        // Сохраняем выбранное значение
        const prevValue = select.value;
        select.innerHTML = ''; // Очищаем

        options.forEach(option => {
            const opt = document.createElement('option');
            opt.value = option[valueKey];
            opt.text = textCallback(option);
            select.appendChild(opt);
        });

        // Восстанавливаем, если есть
        const hasPrev = Array.from(select.options).some(opt => opt.value === prevValue);
        if (hasPrev) {
            select.value = prevValue;
        }
    }

    function filterProfessorsByDiscipline(disciplineCode) {
        const selectedDiscipline = allDisciplines.find(d => d.code == disciplineCode);
        if (!selectedDiscipline) return;

        const filtered = allProfessors.filter(p =>
            p.department === selectedDiscipline.department &&
            p.disciplines.split(',').map(d => d.trim()).includes(selectedDiscipline.name)
        );

        updateSelectOptions(professorSelect, filtered, "personnelNumber", p =>
            `${p.fullName} (${p.department}) - ${p.disciplines}`
        );
    }

    function filterDisciplinesByProfessor(professorNumber) {
        const selectedProfessor = allProfessors.find(p => p.personnelNumber == professorNumber);
        if (!selectedProfessor) return;

        const profDisciplines = selectedProfessor.disciplines.split(',').map(d => d.trim());

        const filtered = allDisciplines.filter(d =>
            d.department === selectedProfessor.department &&
            profDisciplines.includes(d.name)
        );

        updateSelectOptions(disciplineSelect, filtered, "code", d =>
            `${d.name} (${d.department})`
        );
    }

    disciplineSelect.addEventListener('change', () => {
        filterProfessorsByDiscipline(disciplineSelect.value);
    });

    professorSelect.addEventListener('change', () => {
        filterDisciplinesByProfessor(professorSelect.value);
    });
});