window.addEventListener('DOMContentLoaded', (event) => {
    const selectElement = document.querySelector('.operations_list');
    const button = document.getElementById('calculate_button');
    const selectedOption = selectElement.options[selectElement.selectedIndex];
    button.value = selectedOption.text;
});

function updateButtonText(selectElement) {
    const button = document.getElementById('calculate_button');
    const selectedOption = selectElement.options[selectElement.selectedIndex];
    button.value = selectedOption.text;
}

// Retain selected operation after form submission
const selectElement = document.querySelector('.operations_list');
selectElement.addEventListener('change', (event) => {
    const button = document.getElementById('calculate_button');
    const selectedOption = event.target.options[event.target.selectedIndex];
    button.value = selectedOption.text;
});