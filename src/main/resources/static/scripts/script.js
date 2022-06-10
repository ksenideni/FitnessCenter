let arrOfBtn = document.getElementsByClassName('shedule-ftn')
for (let i = 0; i < arrOfBtn.length; i++) {
    arrOfBtn[i].addEventListener('click', dayListenner)
}
document.getElementById("mon").click()

function dayListenner() {
    var id = this.id
    for (let i = 0; i < arrOfBtn.length; i++) {
        arrOfBtn[i].classList.remove("active")
    }
    this.classList.add("active")

    let arrOfCard = document.getElementsByClassName("card-ftn")
    for (let i = 0; i < arrOfCard.length; i++) {
        arrOfCard[i].hidden = true
    }
    let arrOfActiveCard = document.getElementsByClassName(id)
    for (let i = 0; i < arrOfActiveCard.length; i++) {
        arrOfActiveCard[i].hidden = false
    }
}