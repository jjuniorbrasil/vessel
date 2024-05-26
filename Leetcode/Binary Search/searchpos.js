// Most unpractical way

var searchInsert = function(nums, target) {
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] == target) {
            return i;
        }
    }

    for (let i = nums.length; i >= 0; i--) {
        if (target > nums[i]) {
            return i + 1;
        }
    }

    return 0;
};

// Redone