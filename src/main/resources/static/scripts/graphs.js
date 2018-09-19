function doSearch() {
// Do the search
    var searchbx = document.getElementById("searchbox"); // get the searchbox
    var searchterm = searchbx.value; // get the search term
// if it's blank, give up
    if (searchterm == "") {
        alert("Enter a search term"); // put up an explanation for the user
        return; // jump out of this funciton
    }
}


