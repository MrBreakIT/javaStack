// Given a value N, return the corresponding row from Pascal's triangle as an array

// N      Array
// ----------------------
// 0 => [1]
// 1 => [1, 1]
// 2 => [1, 2, 1]
// 3 => [1, 3, 3, 1]
// 4 => [1, 4, 6, 4, 1]


// ********************** using the createPascal method *******************

function createPascalTriangle(numRows) {
    var pascalTriangle = [];

    for (var i = 0; i < numRows; i++) {
        pascalTriangle[i] = new Array(i + 1);

        for (var j = 0; j < i + 1; j++) {
            if (j === 0 || j === i) {
                pascalTriangle[i][j] = 1;
            } else {
                pascalTriangle[i][j] = pascalTriangle[i - 1][j - 1] + pascalTriangle[i - 1][j];
            }
        }
    }
    return pascalTriangle;
}

console.table(createPascalTriangle(15));

// ********************* using recursion *******************************
var numRows = 5,
    triangle,
    start,
    stop;

// N is the no. of rows/tiers 
// a is the 2-D array consisting of the row content

function pascalRecursive(n, a) {
    if (n < 2) return a;
    var prevRow = a[a.length - 1];
    var curRow = [1];
    for (var i = 1; i < prevRow.length; i++) {
        curRow[i] = prevRow[i] + prevRow[i - 1];
    }
    curRow.push(1);
    a.push(curRow);
    return pascalRecursive(n - 1, a); // Call the function recursively
}
var triangle = pascalRecursive(numRows, [[1]]);
for (var i = 0; i < triangle.length; i++)
    console.log(triangle[i] + "\n");

// ********************* using recursion *******************************



















