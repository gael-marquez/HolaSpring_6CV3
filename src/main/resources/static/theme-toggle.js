document.addEventListener('DOMContentLoaded', () => {
    const toggleButton = document.getElementById('toggle-theme');
    const themeIcon = document.getElementById('theme-icon');
    const currentTheme = localStorage.getItem('theme');

    // Aplicar el tema guardado en localStorage
    if (currentTheme === 'light') {
        document.documentElement.classList.add('light-mode');
        themeIcon.textContent = '🌞'; // Sol para modo claro
    }

    toggleButton.addEventListener('click', () => {
        document.documentElement.classList.toggle('light-mode');

        // Cambiar el ícono según el tema
        if (document.documentElement.classList.contains('light-mode')) {
            localStorage.setItem('theme', 'light');
            themeIcon.textContent = '🌞'; // Sol para modo claro
        } else {
            localStorage.setItem('theme', 'dark');
            themeIcon.textContent = '🌙'; // Luna para modo oscuro
        }
    });
});