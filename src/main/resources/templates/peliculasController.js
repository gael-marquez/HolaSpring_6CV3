document.getElementById('searchButton').addEventListener('click', function() {
    const query = document.getElementById('title').value;
    searchMovies(query);
});

async function searchMovies(query) {
    const apiKey = '6dbf9233'; // Reemplaza con tu API key de OMDB
    const url = `https://www.omdbapi.com/?s=${query}&apikey=${apiKey}`;

    try {
        document.getElementById('loading').style.display = 'block';
        document.getElementById('resultsSection').style.display = 'none';
        document.getElementById('noResults').style.display = 'none';
        
        const response = await fetch(url);
        const data = await response.json();

        document.getElementById('loading').style.display = 'none';
        
        if (data.Response === "True") {
            displayResults(data.Search);
        } else {
            displayError(data.Error);
        }
    } catch (error) {
        console.error('Error al buscar películas:', error);
        document.getElementById('loading').style.display = 'none';
        displayError('Error al buscar películas');
    }
}

function displayResults(movies) {
    const results = document.getElementById('movieGrid');
    results.innerHTML = '';

    movies.forEach(movie => {
        const movieElement = document.createElement('div');
        movieElement.classList.add('movie-card');
        movieElement.innerHTML = `
            <div class="movie-poster">
                <img src="${movie.Poster !== 'N/A' ? movie.Poster : 'placeholder.jpg'}" alt="${movie.Title}">
            </div>
            <div class="movie-info">
                <h3 class="movie-title">${movie.Title}</h3>
                <p class="movie-year">Año: ${movie.Year}</p>
                <div class="movie-actions">
                    <button class="movie-button details-button" onclick="window.open('https://www.imdb.com/title/${movie.imdbID}', '_blank')">Ver detalles</button>
                    <button class="movie-button recommend-button" onclick="alert('Película recomendada: ${movie.Title}')">Recomendar</button>
                </div>
            </div>
        `;
        results.appendChild(movieElement);
    });

    document.getElementById('resultsSection').style.display = 'block';
}

function displayError(error) {
    const noResults = document.getElementById('noResults');
    noResults.innerHTML = `<h3>${error}</h3><p>Intenta con otros términos o criterios de búsqueda.</p>`;
    noResults.style.display = 'block';
}