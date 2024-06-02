const form = document.querySelector('#form');
const emailLbl = form.querySelector('.email-label');
const emailInput = form.querySelector('#email');
const submitBtn = document.querySelector('#submit')

const mainCard = document.querySelector('main');
const sucessCard = document.querySelector('.sucess-message');
const emailSpan = sucessCard.querySelector('span');

const disBtn = sucessCard.querySelector('button');

toggleHidden = () => {
    mainCard.classList.toggle('hidden');
    sucessCard.classList.toggle('hidden');
}

function validateSubmit (e) {
    e.preventDefault();

    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    let inputValue = emailInput.value.toLowerCase();

    emailRegex.test(inputValue) ? showSucessCard() : errorInput(); 

    function showSucessCard() {
        emailSpan.innerHTML = emailInput.value;
        toggleHidden(); 
    }
    
    function errorInput() {
        emailLbl.classList.add('error');
        emailInput.classList.add('error');
    }
}

form.addEventListener('submit', (e) => {
    e.preventDefault();
});

disBtn.addEventListener('click', () => {
    emailInput.value = "";
    toggleHidden();
})

submitBtn.addEventListener('click', validateSubmit);