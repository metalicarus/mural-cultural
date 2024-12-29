document.addEventListener("DOMContentLoaded", async () => {
    try {
      const response = await fetch('data.json');
      const data = await response.json();
  
      const eventsContainer = document.getElementById('events');
      data.events.forEach(event => {
        const eventElement = document.createElement('div');
        eventElement.classList.add('col-md-6', 'mb-4');
        eventElement.innerHTML = `
          <div class="card">
            <div class="card-body">
              <h5 class="card-title text-success">${event.name}</h5>
              <p class="card-text">${event.description}</p>
              <p><strong>Data:</strong> ${new Date(event.date).toLocaleString()}</p>
              <p><strong>Local:</strong> ${event.location.address}</p>
            </div>
          </div>
        `;
        eventsContainer.appendChild(eventElement);
      });      
    } catch (error) {
      console.error('Erro ao carregar os eventos:', error);
    }
  });
  