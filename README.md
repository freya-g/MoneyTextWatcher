# MoneyTextWatcher

An android activity which displays an EditText that maintains the $$.cc (dollars and cents) format of user's input with the implementation of the MoneyTextWatcher class.

## How it works:
<div>
 <img src="/Screens/MoneyTextWatcher_1.png" width="500">
</div>
Text displaye on screen will initially be "0.00". The cursor is hidden and all inputs are appened from the right.

After inputting "1", "2", and "3", in order, it will become:
<div>
 <img src="/Screens/MoneyTextWatcher_2.png" width="500">
</div>
The decimal point is automatically inserted into the correct index.

After inputting a backspace, the right most digit will be removed and the string will be rearranged to the correct format again:
<div>
 <img src="/Screens/MoneyTextWatcher_3.png" width="500">
</div>

## About
This was made a part of my MoneyMonster Android application project which helps the user save money.