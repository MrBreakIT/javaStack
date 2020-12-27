// Write a function that takes an array 'function balancePoint(arr)' and returns true if there exists a 'balance point' in the array
// between indicies, where one side's sum is equal to the others
// Example [1, 2, 4, 4, -1, 4] should return 'true'
// 1 + 2 + 4 = 7
// 4 + -1 + 4 = 7


// const sumPoint = (arr) => {
//     const len = arr.length;
//     let sum = 0;
//     let leftsum = 0;
//     for (let i = 0; i < len; i++) {
//         sum += arr[i];
//     }
//     for (let j = 0; j < len; j++) {
//         sum -= arr[j];
//         if (leftsum === sum) {
//             return j;
//         }
//         leftsum += arr[j];
//     }
//     return false;
// }

// const arr = [1, 2, 4, 4, -1, 4];
// console.log(sumPoint(arr));


// // ****************************************from Ahmet
// const balancePoint = (arr) => {

//     // init
//     const len = arr.length - 1,
//         midPoint = Math.floor(len / 2);

//     // init
//     let total = 0, half = 0;

//     // loop
//     for (let i = 0, len = arr.length; i < len; i++) {

//         // grab mid point
//         if (i <= midPoint) {
//             half += arr[i];
//         }

//         // sum total
//         total += arr[i];

//     }

//     // check if half
//     if (half === total / 2) {
//         // return true
//         return true;
//     }

//     // return false
//     return false;

// }

// console.log(balancePoint([1, 2, 4, 4, -1, 4]));
// console.log(balancePoint([1, 2, 4, 4, 4]));
// console.log(balancePoint([1, 2, 3]));


// *************************************from WillGoode

function balancePoint(arr) {

    var left_sum = 0;
    var right_sum = 0;

    for (var i = 0; i < arr.length; i++) {
        right_sum += arr[i];
    }

    for (var i = 0; i < arr.length; i++) {
        if (left_sum === right_sum) {
            return true;
        }
        right_sum -= arr[i];
        left_sum += arr[i];
    }

    return false;

}
console.log(balancePoint([1, 2, 4, 4, -1, 4]));
console.log(balancePoint([1, 2, 4, 4, 4]));
console.log(balancePoint([1, 2, 3]));
