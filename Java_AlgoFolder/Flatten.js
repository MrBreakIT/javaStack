// flatten a given array eliminating nested and empty arrays. Do not alter the array
// instead return a new array (you can assume subarrays don't contain more subarrays)
// Given: [1, [2, 3], 4, [ ], 5] return [1, 2, 3, 4, 5]


// **********************************************using ES6 prototype
const arr = [1, [2, 3], 4, [], 5];

const flattened = arr.flat(Infinity);
console.log(flattened);



// *********************************************can also define the depth of flatten
const arr2 = [0, 1, 2, [[[3, 4]]]];
console.log(arr2.flat(2));


//************************************************using nested for-loop 

const arr3 = [1, [2, 3], 4, [], 5];

function flattenArray(arr3) {
    var newArr = [];
    for (var i = 0; i < arr3.length; i++) {
        if (typeof (arr3[i]) == 'object') {
            for (var j = 0; j < arr3[i].length; j++) {
                newArr.push(arr3[i][j]);

            }
        }
        else {
            newArr.push(arr3[i]);
        }
    }
    return newArr;
}
const x = flattenArray(arr3);
console.log(x);


// *******************************************************Ahmet
function flattenArray(arr, newArr = []) {
    // loop
    for (let i = 0, len = arr.length; i < len; i++) {
        // check if an array
        if (arr[i].constructor === Array) {
            // recrusion
            flattenArray(arr[i], newArr)
        } else {
            // skip objects
            if (arr[i].constructor !== Object) {
                newArr.push(arr[i]);
            }
        }
    }
    // return
    return newArr;
}

console.log(flattenArray([[[[[0]], [1]], [[[2], [3]]], [[4], [5]]]]))


// ***********************************************************Santos
const testArr = [1, [2, 3], 4, [], 5];
const edgeCaseArr = [[1, [[2, 3]], [4, [], 5]]];

function flattenArray(arr, newArr = []) {
    for (var i = 0; i < arr.length; i++) {
        if (typeof (arr[i]) == 'object') {
            flattenArray(arr[i], newArr)
        }
        else {
            newArr.push(arr[i]);
        }
    }
    return newArr;
}

const x1 = flattenArray(edgeCaseArr);
console.log(x1);

// ***********************************************************Santos-2
const testArr1 = [1, [2, 3], 4, [], 5];
function flattenArray1(arr) {
    var newArr = [];
    var done = false;
    while (!done) {
        for (var i = 0; i < arr.length; i++) {
            if (Array.isArray(arr[i])) {
                newArr = newArr.concat(flattenArray1(arr[i]));
            }
            else {
                newArr.push(arr[i]);
            }
        }
        done = true;
    }
    return newArr;
}

const x2 = flattenArray1(testArr);
console.log(x2)