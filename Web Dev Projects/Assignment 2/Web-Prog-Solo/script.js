// Below is for the search bar, searching through the cards by watch name
function searchWatches() {
    var searchTerm = document.getElementById("watch-search").value.toLowerCase();
    var watchList = document.getElementById("watch-list");
    var watches = watchList.getElementsByClassName("watch-card");
    var filterValue = document.getElementById("brand-filter").value;

    for (var i = 0; i < watches.length; i++) {
        var watch = watches[i];
        var watchName = watch.querySelector("h3").innerText.toLowerCase();
        var watchLevel = watch.getElementsByTagName("p")[0].innerText.toLowerCase().split(": ")[1];

        if (watchName.includes(searchTerm) && isWatchVisible(watchLevel, filterValue)) {
            watch.style.display = "block";
        } else {
            watch.style.display = "none";
        }
    }
    console.log("Clicked to search Watches");
}

// Below is for the brands dropdown, only showing cards that have the specific brand
function filterWatchesByBrand() {
    var searchTerm = document.getElementById("watch-search").value.toLowerCase();
    var watchList = document.getElementById("watch-list");
    var watches = watchList.getElementsByClassName("watch-card");
    var filterValue = document.getElementById("brand-filter").value;

    for (var i = 0; i < watches.length; i++) {
        var watch = watches[i];
        var watchName = watch.querySelector("h3").innerText.toLowerCase();
        var watchLevel = watch.getElementsByTagName("p")[0].innerText.toLowerCase().split(": ")[1];

        if (watchName.includes(searchTerm) && isWatchVisible(watchLevel, filterValue)) {
            watch.style.display = "block";
        } else {
            watch.style.display = "none";
        }
    }
    console.log("Clicked to filter Watches");
}

// Below is for the type dropdown, only showing cards that have the specific type. Currently breaks the page; it needs to be fixed
function filterWatchesByType() {
    var searchTerm = document.getElementById("watch-search").value.toLowerCase();
    var watchList = document.getElementById("watch-list");
    var watches = watchList.getElementsByClassName("watch-card");
    var filterValue = document.getElementById("watchtype-filter").value;

    for (var i = 0; i < watches.length; i++) {
        var watch = watches[i];
        var watchName = watch.querySelector("h3").innerText.toLowerCase();
        var watchLevel = watch.getElementsByTagName("p")[0].innerText.toLowerCase().split(": ")[1];

        if (watchName.includes(searchTerm) && isWatchVisible(watchLevel, filterValue)) {
            watch.style.display = "block";
        } else {
            watch.style.display = "none";
        }
    }
    console.log("Clicked to filter Watches");
}

// Below is for the price dropdown, sorting the cards by price. One card isn't sorted properly though.
function sortWatches() {
    var sortOrder = document.getElementById("price-filter").value;
    var watchList = document.getElementById("watch-list");
    var watches = watchList.getElementsByClassName("watchlist-card");

    var sortedWatches = Array.from(watches).sort(function (a, b) {
        var levelA = a.getElementsByTagName("p")[0].innerText.toLowerCase().split(": ")[1];
        var levelB = b.getElementsByTagName("p")[0].innerText.toLowerCase().split(": ")[1];

        var brandValues = {
            "timex": 1,
            "rolex": 2,
            "burberry": 3
        };

        if (sortOrder === "lowToHigh") {
            return brandValues[levelA] - brandValues[levelB];
        } else {
            return brandValues[levelB] - brandValues[levelA];
        }
    });

    for (var i = 0; i < sortedWatches.length; i++) {
        watchList.appendChild(sortedWatches[i]);
    }
    console.log("Clicked to sort Watches");
    
}

function isWatchVisible(watchLevel, filterValue) {
    if (filterValue === "" || watchLevel === filterValue) {
        return true;
    }
    return false;
}