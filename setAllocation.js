function allocateSeats(numSeats, seatAvailabilityMap) {
    for (let block of seatAvailabilityMap) {
        let contiguousSeats = [];
        let count = 0;

        for (let seat of block) {
            let seatNumber = Object.keys(seat)[0];
            let isAvailable = seat[seatNumber];

            if (isAvailable) {
                contiguousSeats.push(seatNumber);
                count++;
                if (count === numSeats) {
                    // Mark seats as allocated
                    for (let seatNum of contiguousSeats) {
                        for (let s of block) {
                            if (s.hasOwnProperty(seatNum)) {
                                s[seatNum] = false;
                            }
                        }
                    }
                    return contiguousSeats;
                }
            } else {
                contiguousSeats = [];
                count = 0;
            }
        }
    }
    return [];
}

// Example 
const seatAvailabilityMap = [
  [ { 'a1':  true }, { 'a2': true }, {'a3': false }, { 'a4': true }, { 'a5': true }, { 'a6': true }, { 'a7': true } ],
  [ {'a8': true }, {'a9': true }, {'a10': true }, { 'a11': false }, { 'a12': true }, { 'a13': true }, { 'a14': false } ],
  [ {'b1': true }, {'b2': true }, { 'b3': true }, { 'b4': true }, { 'b5': true }, { 'b6': true }, { 'b7': true }, { 'b8': true }, { 'b9': true }, { 'b10': true } ],
];

console.log(allocateSeats(3, seatAvailabilityMap));