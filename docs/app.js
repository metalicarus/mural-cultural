document.addEventListener("DOMContentLoaded", async () => {
    try {
      const response = await fetch('data.json');
      const data = await response.json();
  
      const eventsContainer = document.getElementById('events');
      data.events.forEach(event => {
        const eventElement = document.createElement('div');
        eventElement.classList.add('event');
        eventElement.innerHTML = `
          <h2>${event.name}</h2>
          <p>${event.description}</p>
          <p><strong>Data:</strong> ${new Date(event.date).toLocaleString()}</p>
          <p><strong>Local:</strong> ${event.location.address}</p>
        `;
        eventsContainer.appendChild(eventElement);
      });
    } catch (error) {
      console.error('Erro ao carregar os eventos:', error);
    }
  });
  