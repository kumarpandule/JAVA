// I am currently using Node.js v20.17.0
const crypto = require('crypto');

function couponGenerator() {
  return new Promise((resolve, reject) => {
    setTimeout(
      () => {
         const coupon = {
           code: crypto.randomBytes(8).toString('hex'),
           available: Math.random() > 0.7
         };
         resolve(coupon);
      },
      50
    );
  });
}

async function collectCoupons(n) {
  const coupons = [];
  
  while (coupons.length < n) {
    const coupon = await couponGenerator();
    if (coupon.available) {
      coupons.push(coupon.code);
    }
  }
  
  return coupons;
}

// for example for collect 5 coupons
collectCoupons(5).then(coupons => console.log(coupons));