// Remove array duplicates. Do not alter the original array 
// return the new array with the results 'stable', in the original order
// Given: [1, 2, 1, 3, 4, 2] return [1, 2, 3, 4]

// Remove array duplicates. Do not alter the original array 
// return the new array with the results 'stable', in the original order
// Given: [1, 2, 1, 3, 4, 2] return [1, 2, 3, 4]


// ******************************************************** from Ahmet


function removeDuplicates1(arr) {

    // init
    var newArr = [],
        len = arr.length,
        index = 0,
        i = index;

    // loop
    while (i < len) {

        // dont update current index
        if (index != i) {

            // blank out the same value
            if (arr[index] === arr[i]) {
                arr[i] = "";
            }

        }

        // increment
        i++;

        //reached end 
        if (i >= len) {

            // add to newArr
            if (arr[index] != "") {
                newArr.push(arr[index])
            }

            // reset - jump to next
            index++;
            i = index;

        }

    }

    //return
    return newArr;

}

// Part 2: work 'in place' (alter the original array)
// alter the order if necessary
// Ex. [1, 2, 1, 3, 4, 2] could become [1, 2, 4, 3]
function removeDuplicates2(arr) {

    // init
    var len = arr.length,
        index = 0,
        i = index,
        j = 0,
        again = false,
        done = false;

    // loop
    while (!done) {

        // as long as i is less then len keep going...
        if (i < len) {

            // dont update current index
            if (index != i) {

                // blank out the same value
                if (arr[index] === arr[i]) {
                    arr[i] = "";
                }

            }

            // increment
            i++;

            //reached end 
            if (i >= len) {

                // reset - jump to next
                index++;
                i = index;

            }

            // we now have blanks remove them from arr
        } else {

            // loop
            if (j < len) {

                //check last value
                if (arr[arr.length - 1] == "") {

                    // pop off blanks
                    arr.pop();

                }

                // check for blanks
                if (arr[j] == "" && arr[j + 1]) {

                    [arr[j], arr[j + 1]] = [arr[j + 1], arr[j]]

                    // go again
                    again = true;

                }

                // increment j
                j++;

            } else {

                // check if we go again
                if (!again) {

                    // terminate loop
                    done = true;

                }

            }

            // reset again
            again = false;

        }

    }

    // return 
    return arr;

}

// Part 3: make the remove duplicates both
// 'in place' and 'stable'
function removeDuplicates3(arr) {

    return removeDuplicates2(arr);
}


// output
console.log(removeDuplicates1([1, 2, 1, 3, 4, 2, 2]));
console.log(removeDuplicates2([1, 2, 1, 3, 4, 2, 2]));
console.log(removeDuplicates3([1, 2, 1, 3, 4, 2, 2]));