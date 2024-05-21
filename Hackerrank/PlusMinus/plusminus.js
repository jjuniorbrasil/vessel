function plusMinus(arr) {
    let arrSize = arr.length;
    let pos = 0;
    let neg = 0;
    let zero = 0;
    for (let i = 0; i < arrSize; i++) {
        if (arr[i] > 0) {
            pos++;
        } else if (arr[i] < 0) {
            neg++;
        } else {
            zero++;
        }
    }
     console.log((pos/arrSize).toFixed(6));
     console.log((neg/arrSize).toFixed(6));
     console.log((zero/arrSize).toFixed(6));
}

plusMinus([1, 1, 0, -1, -1]);