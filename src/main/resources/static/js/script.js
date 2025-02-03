document.addEventListener("DOMContentLoaded", function () {
    document.querySelectorAll(".delete-btn").forEach(button => {
        button.addEventListener("click", function () {
            const id = this.getAttribute("data-id");
            if (confirm("Are you sure you want to delete this T-Shirt?")) {
                fetch(`/tshirts/delete/${id}`, {
                    method: "DELETE"
                }).then(response => {
                    if (response.ok) {
                        window.location.reload();
                    } else {
                        alert("Error deleting T-Shirt");
                    }
                });
            }
        });
    });

    document.querySelectorAll(".edit-btn").forEach(button => {
        button.addEventListener("click", function () {
            const id = this.getAttribute("data-id");
            window.location.href = `/tshirts/edit/${id}`;
        });
    });
});
