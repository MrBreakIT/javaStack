// Given an array of numbers that are organized in ascending order and a number 'value' 
// return true if the value is present

var items = [1, 2, 3, 4, 5, 7, 8, 9];

function binarySearch(items, value) {
    var firstIndex = 0,
        lastIndex = items.length - 1,
        middleIndex = Math.floor((lastIndex + firstIndex) / 2);

    while (items[middleIndex] != value && firstIndex < lastIndex) {
        if (value < items[middleIndex]) {
            lastIndex = middleIndex - 1;
        }
        else if (value > items[middleIndex]) {
            firstIndex = middleIndex + 1;
        }
        middleIndex = Math.floor((lastIndex + firstIndex) / 2);
    }

    return (items[middleIndex] != value) ? -1 : middleIndex;
}


console.log(binarySearch(items, 1));
console.log(binarySearch(items, 5));
// do we need to check every value in the array? can we speed up the search process?



// *********************************************** from Santos *********************************

const testArr = [1, 2, 33, 44, 56, 78, 94];

function binarySearch(arr, value) {
    if (arr[arr.length / 2] = value) {
        return true
    }
    if (arr[arr.length / 2] > value) {
        for (var i = arr[arr.length / 2]; i <= 0; i--) {
            if (arr[i] == value) {
                return true;
            }
        }
    }
    if (arr[arr.length / 2] < value) {
        for (var i = arr[arr.length / 2]; i < arr.length; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
    }
}

x = binarySearch(testArr, 56);
console.log(x);

// *********************************************** from Will Goode *********************************
function binarySearch(arr, val) {
    var sta = 0;
    var end = arr.length - 1;
    while (sta < end) {
        var mid = Math.floor((sta + end) / 2);
        if (arr[mid] === val) {
            return true;
        }
        if (val > arr[mid]) {
            sta = mid + 1;
        } else if (val < arr[mid]) {
            end = mid - 1;
        }
    }
    if (arr[sta] === val) {
        return true;
    }

    return false;
}

console.log(binarySearch([2, 3, 4, 6, 8, 10, 11, 12, 13, 15, 17, 21, 22], 5));
