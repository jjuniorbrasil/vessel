var expect = function(val) {
    return {
        toBe : function (otherval) {
            return (otherval == val) ? true : false;
        },

        notToBe : function (otherval) {
            return (otherval != val) ? true : false;
        }
    }
};

console.log(expect(5).toBe(6));