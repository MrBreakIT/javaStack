// Given 3 numbers, return true if they could be the sides of a right triangle(the Pythagorean theorem may prove useful a ^ 2 + b ^ 2 = c ^ 2) and false if not.The values can be provided in any order, 'c' is not necessarily the largest.

// function isRight(a, b, c) {
// }

// Given(4, 5, 3) return true
// Given(3, 3, 3) return false


//////////////////////////////////////////// from Ahmet
function isRight(a, b, c) {


    //we have something to work with
    if (a > 0 && b > 0 && c > 0) {

        //sort nums
        // let nums = [a, b, c].sort((a, b) => a - b);

        //check all possible combos
        if (((a * a) + (b * b) == (c * c)) ||
            ((b * b) + (c * c) == (a * a)) ||
            ((c * c) + (a * a) == (b * b))
        ) {
            return true;
        }

        // //Pythagorean Theorem
        // if(((nums[0] * nums[0]) + (nums[1] * nums[1])) == (nums[2] * nums[2])){
        //     return true;
        // }

    }

    return false;

}


////////////////////////////// from ErivViera
function isRight(a, b, c) {
    let newArr = [a, b, c];
    let max = newArr[0];
    for (var i = 0; i < newArr.length; i++) {
        if (newArr[i] > max) {
            max = newArr[i];
        }
    }
    if (a == max) {
        var aSquare = a * a;
        var bSquare = b * b;
        var cSquare = c * c;
        var sum = bSquare + cSquare;
        if (sum == aSquare) {
            return true;
        }
        else {
            return false;
        }
    }
    else if (b == max) {
        var aSquare = a * a;
        var bSquare = b * b;
        var cSquare = c * c;
        var sum = aSquare + cSquare;
        if (sum == bSquare) {
            return true;
        }
        else {
            return false;
        }
    }
    else if (c == max) {
        var aSquare = a * a;
        var bSquare = b * b;
        var cSquare = c * c;
        var sum = bSquare + aSquare;
        if (sum == cSquare) {
            return true;
        }
        else {
            return false;
        }
    }
}







