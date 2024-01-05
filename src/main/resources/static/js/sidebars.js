/*const triggerTabList = document.querySelectorAll('#sidebar a')
triggerTabList.forEach(triggerEl => {
  const tabTrigger = new bootstrap.Tab(triggerEl)

  triggerEl.addEventListener('click', event => {
    event.preventDefault()
    tabTrigger.show()
  })
})
*/


function detecterURL() {
  // Récupérer l'URL actuelle
  let url = window.location.href;

  // Sélectionner les éléments a que tu veux modifier
  let aElements = document.querySelectorAll('#sidebar ul.nav li a');

  // Retirer la classe 'active' de tous les éléments a
  aElements.forEach(a => {
    a.classList.remove('active');
  });

  // Vérifier l'URL et changer la classe en conséquence pour chaque élément a
  aElements.forEach(a => {
    let linkURL = a.getAttribute('href');

    if (url.includes(linkURL)) {
      a.classList.add('active');
    }
  });
}

// Appeler la fonction detecterURL() au chargement de la page
window.onload = detecterURL;

/*

let tabs = document.querySelectorAll(" #sidebar li a");
let panels = document.querySelectorAll(" #info-box article");

for (let i = 0; i < tabs.length; i++) {
  let tab = tabs[i];
  setTabHandler(tab, i);
}

function setTabHandler(tab, tabPos) {
  tab.onclick = function () {
    for (let i = 0; i < tabs.length; i++) {
      tabs[i].className = "nav-link text-white";
    }

    tab.className = "nav-link active";

    for (let i = 0; i < panels.length; i++) {
      panels[i].className = "";
    }

    panels[tabPos].className = "active-panel";
  };
}
*/
