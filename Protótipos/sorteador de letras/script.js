const selectIni = document.querySelector('#select-letra-inicial')
const selectFim = document.querySelector('#select-letra-final')
const selectQtd = document.querySelector('#select-qtd');
const btnSortear = document.querySelector('.btnSortear');
const sorteadas = document.querySelector('.sorteadas');
const info = document.querySelector('.info');
const letras = ["A","B","C","D","E","F","G","H","I","J",
                "K","L","M","N","O","P","Q","R","S","T",
                "U","V","W","X","Y","Z"];

function carregarLetras() {
    for (let letra of letras) {
        let option = document.createElement('option');
        option.value = letra;
        option.innerHTML = letra;
        selectIni.appendChild(option);
        selectFim.appendChild(option.cloneNode(true));
    }
}

function indiceAleatorio(n) {
    let num = (Math.random() * n).toFixed();
    return num;
}

function sortearLetras(qtd) {
    sorteadas.innerHTML = '';
    let letrasCopy = [...letras];

    const min = letras.indexOf(selectIni.value);
    const max = letras.indexOf(selectFim.value);

    letrasCopy = letrasCopy.slice(min, max + 1);
    
    const letrasArr = [];
    const error = document.createElement('span');
    error.innerHTML = '<strong>Operação inválida!</strong>';
    error.className = 'error';
    info.innerHTML = '';
    let sucess = document.createElement('h3');
    let valid = true;
    
    if (qtd <= 0) {
        sorteadas.appendChild(error);
        sucess.innerHTML = '';
        valid = false;
        throw new TypeError('Quantidade a ser sorteada é menor ou igual a \'0\'.');
    };
    
    for (let i = 0; i < qtd; i++) {
        let letra = document.createElement('h1');
        let indice = indiceAleatorio(max-min-i);
        
        if (indice < 0) { 
                sorteadas.appendChild(error);
                sucess.innerHTML = '';
                valid = false;
                throw new TypeError('Intervalo de sorteio inválido.');
            };

            if (typeof letrasCopy[indice] === 'undefined') break;
            letra.innerHTML = letrasCopy[indice];

            letrasCopy.splice(indice, 1);   // remove do array
            letrasArr.push(letra);
    }

    let copyToClipboard = letrasArr.reduce((acc, el) => {
        acc.push(el.innerHTML);
        return acc;
    }, []);

    navigator.clipboard.writeText(copyToClipboard.toString());

    if (valid === true) {
        sucess.className = 'sucess';
        sucess.innerHTML = 'Letras copiadas para a área de transferência!';
        info.appendChild(sucess);
    }

    for (let letra = 0; letra < letrasArr.length; letra++) {
        setTimeout(() => {
            letrasArr[letra].style.transition = "none";
            letrasArr[letra].classList.toggle('appear', false); 
            sorteadas.appendChild(letrasArr[letra]);
    
            letrasArr[letra].offsetHeight;
            
            letrasArr[letra].style.transition = "opacity 1.618s"; // Defina a transição novamente
            letrasArr[letra].classList.toggle('appear', true); // Adicione a classe 'appear' para iniciar a transição
        }, 161.8*letra);
    }
}

btnSortear.addEventListener('click', function(e) {
    e.preventDefault();
    const qtd = selectQtd.value;
    try {
        sortearLetras(qtd);
    } catch (err) {
        console.error('ERRO: ', err);
    }
})

function shuffleArray(array) {
    for (var i = array.length - 1; i > 0; i--) {
        var j = Math.floor(Math.random() * (i + 1));
        var temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    return array;
}

btnSortear.onmouseenter = function (e) {
    let el = e.target;
    el.style.setProperty('letter-spacing', '0.2em');
    el.innerHTML = el.innerHTML.toUpperCase();
}

btnSortear.onmouseout = function (e) {
    let el = e.target;
    el.style.setProperty('letter-spacing', 'normal');
    el.innerHTML = 'Sortear';
}

carregarLetras();