var createCounter = function(init) {
    var currentValue = init;
    var originalValue = init;
    return {
        increment : () => {
            return ++currentValue;
        },

        decrement : () => {
            return --currentValue;
        },

        reset     : () => {
            currentValue = originalValue;
            return originalValue;
        }
    }
};