localStorage.clear();

// Récupérer tous les boutons "Ajouter au panier"
const buttons = document.querySelectorAll('.ajouterPanier');

buttons.forEach(button => {
    button.addEventListener('click', event => {
        // Récupérer la ligne tr parente du bouton cliqué
        const row = event.target.closest('tr');

        // Récupérer les informations du médicament à partir des balises span dans la ligne
        const nomMedicament = row.querySelector('td:nth-child(1) span').innerText;
        const prixMedicament = parseFloat(row.querySelector('td:nth-child(2) span').innerText);

        // Créer un objet représentant le médicament à ajouter au panier
        const medicamentToAdd = {
            Medi_Nom: nomMedicament,
            Medi_Prix: prixMedicament,
            quantity: 1 // Initialiser la quantité à 1 par défaut
        };

        // Récupérer le panier depuis le localStorage
        let panier = JSON.parse(localStorage.getItem('panier')) || [];

        // Vérifier si le médicament est déjà dans le panier
        const existingItem = panier.find(item => item.Medi_Nom === medicamentToAdd.Medi_Nom);

        if (existingItem) {
            // Si le médicament est déjà dans le panier, augmenter la quantité
            existingItem.quantity++;
        } else {
            // Sinon, ajouter le médicament avec une quantité de 1
            panier.push(medicamentToAdd);
        }

        // Mettre à jour le panier dans le localStorage
        localStorage.setItem('panier', JSON.stringify(panier));

        // Actualiser l'affichage du panier (mettez à jour le tableau HTML)
        refreshPanierDisplay();
    });
});

// Fonction pour rafraîchir l'affichage du panier
function refreshPanierDisplay() {
    const panierTableBody = document.getElementById('panierBody');
    panierTableBody.innerHTML = ''; // Effacer le contenu actuel du tableau

    let panier = JSON.parse(localStorage.getItem('panier')) || [];

    if (panier.length === 0) {
        // Si le panier est vide, afficher un message approprié
        panierTableBody.innerHTML = `
            <tr>
                <td colspan="4">Votre panier est vide.</td>
            </tr>
        `;
    } else {
        // Sinon, afficher chaque élément du panier dans le tableau
        panier.forEach(item => {
            const totalPrice = item.Medi_Prix * item.quantity;

            panierTableBody.innerHTML += `
                <tr>
                    <td>${item.Medi_Nom}</td>
                    <td>${item.quantity}</td>
                    <td>${item.Medi_Prix}</td>
                    <td>${totalPrice}</td>
                </tr>
            `;
        });
    }
}

