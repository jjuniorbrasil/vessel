var filter = function(arr, fn) {
    let filteredArr = [];
    let arrSize = arr.length;

    for (let i = 0; i < arrSize; i++) {
        if (fn(arr[i], i)) {
            filteredArr.push(arr[i]);
        }
    }

    return filteredArr;
};