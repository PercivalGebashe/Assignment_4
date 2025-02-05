document.addEventListener("DOMContentLoaded", function () {
    const cardsPerPage = 16; // Now showing 16 cards per page
    let currentPage = 1;
    const cards = document.querySelectorAll(".product-card");
    const totalPages = Math.ceil(cards.length / cardsPerPage);

    function showPage(page) {
        cards.forEach((card, index) => {
            if (index >= (page - 1) * cardsPerPage && index < page * cardsPerPage) {
                card.style.display = "block";
            } else {
                card.style.display = "none";
            }
        });
    }

    function createPaginationButtons() {
        const pagination = document.querySelector(".pagination");
        pagination.innerHTML = "";

        for (let i = 1; i <= totalPages; i++) {
            const button = document.createElement("button");
            button.textContent = i;
            button.addEventListener("click", () => {
                currentPage = i;
                showPage(currentPage);
            });
            pagination.appendChild(button);
        }
    }

    showPage(currentPage);
    createPaginationButtons();
});