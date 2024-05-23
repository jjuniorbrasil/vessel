var map = function(arr, fn) {
    let newArr = [];
    let arrSize = arr.length;

    for (let i = 0; i < arrSize; i++) {
        newArr[i] = fn(arr[i], i);
    }

    return newArr;
};