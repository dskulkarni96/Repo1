I have implemented below endpoints

POST /coupons: Create a new coupon. 
GET /coupons: Retrieve all coupons. 
GET /coupons/{id}: Retrieve a specific coupon by its ID. 
PUT /coupons/{id}: Update a specific coupon by its ID. 
DELETE /coupons/{id}: Delete a specific coupon by its ID.

Other 2 endpoints, I started doing it but couldnt implement, since I got bit conused but I may have rough idea about it.

POST /applicable-coupons:
Create restapi with Cart items as requst body. Send to service where it will be checked if any cart wise or item 
wise condition is satisfied.(We can write logic to see if amount is exceeding particular limit by extracting the 
itemcart object) OR we can just again check into the itemcart to see if particular item is present which allows discount.

Then depending on which condition satisifes, we write HQL query to fetch if any existing coupons are there.
After that we calculate the discounted value.

POST /apply-coupon/{id}:

Next step in above is , after fetching copuons, just apply a coupon to cart we have. Again business logic where
we can just add up item cart price , fetch what is discount perecentage from what we got from the table and
calculate new value and return it back. We can apply the discount item wise as well (e.g. if there are 3 itmes
worth 40,50,30 rs each and discount is 10%, we can either apply it on total of 120 which will be 12rs and give that back
or just add up 10% of 40, 10% of 50 and 10% of 30 which again comes to 30 but representation will be different.)

Limitations -:

I am able to visualize scenario for the cases I cant write , can write pseudo code but unable to put it down in the format 
of the code which I could run properly. Its not like I cant see the logic beihnd that , just became bit complex. Maybe can do it 
with more time given.

Assumptions -:

Have added only few columns for Coupon table, considered coupon as a single entity so clubbing of 2 coupons may not be applicable 
at the data level(this will have to be executed at service level).
During update coupon, assumed that user wont enter wrong couponId, I tried penning down logic for that exception but didnt work out.
Other places as well, I tried having exceptions but gotten multiple errors. So other things are also assumed such as cannot delete coupon
which does not exist. Cannot findById coupon which does not exist.


