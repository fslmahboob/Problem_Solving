// Create a function that renders the three team images
// Use a for loop, template strings (``), plus equals (+=)
// .innerHTML to solve the challenge.

/**
 * Skills:
 *  -JS functions
 *  -JS for loops
 *  -JS arrays
 *  -JS counter & updating it
 *  -JS template strings/literals
 *  -JS .innerHTML
 * 
 * Status: Complete
 */

const imgs = [
    "images/hip1.jpg",
    "images/hip2.jpg",
    "images/hip3.jpg"
]

function rimage(imgs){
    let a = document.getElementById("container")
    for (let i=0 ; i < imgs.length; i++){
        a.innerHTML += `<img class="team-img" src=${imgs[i]}>`
    }
}


rimage(imgs)