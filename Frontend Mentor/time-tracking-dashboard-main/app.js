import data from './data.json' with { type : "json" };

const mainCard = document.querySelector('.main-card');
const viewLinks = mainCard.querySelectorAll('.links a');
const allCards = document.querySelectorAll('.card');
const cardStates = {
    "work" : 'weekly',
    "play" : 'weekly',
    "study" : 'weekly',
    "exercise" : 'weekly',
    "social" : 'weekly',
    "selfcare" : 'weekly',
};

for (let link of viewLinks) {
    link.addEventListener('click', stateChange);
}

function stateChange(e) {
    let newState = e.target.innerHTML.toLowerCase();
    let cards = ['work', 'play', 'study', 'exercise', 'social', 'selfcare'];
    for (let card of cards) {
        cardStates[card] = newState;
    }
    allCards.forEach(loadCardData);
}

function cardStateChange() {
    // change state of specific card and load its data
}

function loadCardData (card) {
    // variables
    let cardName = card.querySelector('.title').innerHTML.toLowerCase().replace(" ", "");
    let cardState = cardStates[cardName];
    let hours = card.querySelector('.hours');
    let previous = card.querySelector('.previous');

    let cardData = data.filter((choosenCard) => { return choosenCard.title.toLowerCase().replace(" ", "") == cardName; })[0];
    let time = cardData.timeframes;

    time = time[cardState];

    let lastPeriod = (state) => {
        let info = state == 'daily' ? 'Yesterday' : (state == 'weekly' ? 'Last Week' : 'Last Month');
        return info;
    }

    // fill info
    hours.innerHTML = `${time.current}hrs`;
    previous.innerHTML = `${lastPeriod(cardState)} - ${time.previous}hrs`;
}

allCards.forEach(loadCardData);