// Given 2 strings, write a function that returns 'true' if they are rotations of each other(same letters in the same order just shifted by some number of characters) and false if they are not...

// function isRotation(str1, str2) {
// }

// Given("bingo", "gobin") return true
// Given("bingo", "oginb") return false 


//////////////////////////////////////////// from Ahmet
// function isRotation(str1, str2) {

//     //string not same length
//     if (str1.length < str2.length) {
//         return false;
//     }

//     //init
//     let strings = str2 + str2, count = 0;

//     //loop thru letters
//     for (c of strings) {

//         //check matching letters
//         if (c == str1[count]) {

//             //increment count
//             count++

//             //string found
//             if (count == str1.length) {
//                 return true;
//             }

//             //reset count
//         } else {
//             count = 0;
//         }

//     }

//     // //check if string exists
//     // if(strings.indexOf(str1) != -1){
//     //     return true;
//     // }

//     //return false
//     return false;

// }

//////////////////////////////////////////////// from WillGoode
function isRotation(str1, str2) {

    if (str1.length !== str2.length) {
        return false;
    }

    for (let i = 0; i < str2.length; i++) {
        // find the starting point
        if (str1[0] === str2[i]) {
            // we found the first letter in str1 somewhere in str2
            // starting at i... lets compare j in str1 with i+j in str2
            let all_match = true;
            for (let j = 1; j < str2.length - i; j++) {
                if (str1[j] !== str2[i + j]) {
                    all_match = false;
                }
            }
            // starting j at 0 compare the initial letter in str1 with str2 
            for (let j = 0; j < i; j++) {
                if (str2[j] !== str1[i + j + 1]) {
                    all_match = false;
                }
            }
            if (all_match) {
                return true;
            }
        }
    }

    return false;

}

console.log(isRotation("bingo", "gobin"));
console.log(isRotation("bingo", "oginb"));



////////////////////////////// from ErivViera
function isRotation(str1, str2) {
    if (str1.length !== str2.length) {
        return false;
    }
    else {
        arr1 = [];
        for (var i = 0; i < str1.length; i++) {
            arr1.push(str1[i]);
        }
        for (var i = 0; i < arr1.length; i++) {
            console.log("Beginning", arr1);
            var temp = arr1[arr1.length - 1];
            for (var j = 0; j < arr1.length; j++) {
                if (j == 0) {
                    let temp2 = arr1[j];
                    arr1[j] = temp;
                    temp = temp2;
                }
                else {
                    let temp3 = arr1[j];
                    arr1[j] = temp;
                    temp = temp3;
                }
            }
            temp3 = null;
            var newStr = "";
            for (var k = 0; k < arr1.length; k++) {
                newStr += arr1[k];
            }
            if (newStr == str2) {
                return true;
            }
            console.log("End", arr1);
        }
        return false;
    }
}