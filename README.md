# W22G7_UrbanHome
This App will show the ideas to customers based on the type and color of the furniture they would like to buy.

## Description ##
* This is an app where you can buy furniture and home decor online. You can shop for items and add them to your shopping cart. After payment, you'll be able to see the order information for the items.

## Installation ##
* Install Android Studio
https://developer.android.com/studio
* Install the right SDK for your phone
* Create an Android Virtual Device


## Features ##
* Login- This App contains simple Login form, Registration form with SQLite database operations are performed to store username and password. It allows the user to log in once registered. After successfully logging in, the user returned to the home screen. Users can subsequently log in through Google and Facebook accounts, we have integrated the Google Sign-In functionality and Facebook SDK.
* Feedback- To collect and hear customer’s feedback, user’s email and message are saved in a file using RoomDB once they send.
* Maps-
* Shopping Cart- Once items are added to cart, a file using RoomDB is made and id, name, price, and quantity of the item are saved. Item name, quantity, and price are visible in the cart. The user can edit the quantity of each item or delete the item, and price is calculated. 
* Order Details- Users have a history of purchased items in order details. Once payment is done, datas in the file of shopping cart are deleted and moved to a new file which is of order details.
* Payment System- A ready-made interactive card form that can be included in our app, making it easy to accept credit and debit cards. Everything is created with Android SDK.
