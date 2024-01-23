// affichage-du-panier.js
document.addEventListener('DOMContentLoaded', function () {
    // Récupérer les données du panier depuis le localStorage
    let panier = JSON.parse(localStorage.getItem('panier')) || [];

    // Appeler une fonction pour afficher le panier
    displayPanier(panier);
});

// Fonction pour afficher le panier
function displayPanier(panier) {
    const panierTableBody = document.getElementById('panierBody');
    panierTableBody.innerHTML = '';

    if (panier.length === 0) {
        panierTableBody.innerHTML = `
            <tr>
                <td colspan="4">Votre panier est vide.</td>
            </tr>
        `;
    } else {
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
