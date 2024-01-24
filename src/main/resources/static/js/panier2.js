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
        panier.forEach((item, index) => {
            const totalPrice = item.Medi_Prix * item.quantity;

            panierTableBody.innerHTML += `
                <tr>
                    <td hidden><input type="text" value="${item.Medi_ID}" th:field="*{Medicament.Medi_ID}" /></td>
                    <td>${item.Medi_Nom}</td>
                    <td><input type="text"  value="${item.quantity}" th:field="*{Panier_Qte}" /></td>
                    <td>${item.Medi_Prix}</td>
                    <td>${totalPrice}</td>
                </tr>
            `;
        });

        // Ajouter un gestionnaire d'événements pour capturer les modifications des champs quantity
        document.querySelectorAll('input[name^="panier.items"]').forEach(input => {
            input.addEventListener('input', function() {
                // Récupérez les valeurs mises à jour
                var mediIdInput = this.closest('tr').querySelector('input[name$="Medi_ID"]');
                var mediId = mediIdInput ? mediIdInput.value : null; // Assurez-vous que Medi_ID n'est pas null

                var quantity = this.value;

                // Vous pouvez maintenant envoyer ces valeurs côté serveur via une requête AJAX
                // Exemple avec fetch API
                fetch('/updatePanier', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify({
                        'Medi_ID': mediId,
                        'quantity': quantity,
                    }),
                })
                    .then(response => {
                        if (!response.ok) {
                            throw new Error(`Erreur de mise à jour : ${response.status}`);
                        }
                        console.log('Mise à jour réussie');
                    })
                    .catch(error => {
                        console.error('Erreur de mise à jour', error);
                    });
            });
        });
    }
}



// Récupération de l'ID pour le Panier
document.addEventListener('DOMContentLoaded', function(){
   let idRecup = document.getElementById('idRecup');
   let id = idRecup.value;
   let idInput = document.getElementById('idInput');

   idInput.value = id;
});
