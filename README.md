
# POS System COMPX568

## Project Brief

The goal of this project is to create a file-based inventory management and point-of-sale application, analogous to those you might find in online or in-person retail businesses. This application has 2 major components: The first being the 'backend' inventory management facet, where products for sale can be added, removed, and modified; and the second being the 'frontend' point-of-sale where products can be added to a sale, and a receipt produced.

Data used by this application is written to, and read from a local file on the computer.


Swing Interface
Design Pattern 
Version control usage

## General Notes

The application makes use of a file to store the details of the items in the inventory. It read from, and writes to this file on a regular basis.

It the inventory state to the file after every change, without requiring a save button or hotkey be pressed.

## Welcome Screen

1. When the application is first started, the user should is presented with a welcome screen window, which prompts the user to select an existing filestore, or create a new one.

2. Following selection of a filestore, the window content should are replaced with 3 options - Close filestore, Open Inventory Manager, and Open Point of Sale.
   + Selecting "Close filestore" closes the current filestore and return the window to the initial create or open filestore prompt
   + Selecting "Open Inventory Manager"shows the inventory manager content
   + Selecting "Open Point of Sale" shows the point of sale content


## Inventory Manager

The inventory manager allows for products to be created, viewed, modified, and removed in the open filestore using appropriate Swing controls. It ensures that the inventory is saved to the open filestore regularly, without requiring a specific button be pressed. 

1. Inventory items consists of:
   + A unique 10-character identifier, consisting only of numbers and uppercase letters
   + A product name
   + A product description
   + A numeric price per unit
   + A numeric stock quantity (how many of this product are in stock)

2. When opened, inventory items are initially loaded from the selected filestore
    + A new filestore does not contain any items, the application handles this without error

3. Inventory items should are displayed in a table. This table is scrollable, so that large numbers of entries can be displayed

4. User can create new inventory items. Values provided for each of the item's fields are validated, ensuring that the price and stock quantity are numeric values, and that the identifier is unique within the filestore and conforms to the required format

5. Existing inventory items can be removed

6. Existing inventory items are editable. All fields making up an inventory are, and validated before allowing the edit.
be available

## Point of Sale

The point of sale window  allows a user to browse through a list of products, and allows these to be added to a cart. Many items can be added to a cart as a single transaction, and when ready the user can "checkout", removing items from the inventory and producing a formatted receipt.It also provides an option to return to the Welcome Screen.

1. Inventory items are loaded from the open filestore and presented within the window for the user to select from. Only items that are in stock are shown

3. Items can be removed from the cart, returning them to the inventory.

4. Items added to the cart are displayed in the order that they were added, and items can added one-by-one

5. Sequential entries in the cart that are the same item are 'combined' to display as a single item with a listed quantity - e.g., products added in sequence 'A', 'A', 'A', 'B', 'C', 'C', 'A', 'A', 'C' are displayed as 'A (3)', 'B', 'C (2)', 'A (2)', 'C'. Removing a 'combined' item from the cart removes one instance - e.g., removing 'A (3)' should result in 'A (2)'

6. A running total cost of all items in the cart is displayed. 

7. Receipt files are generated when the user checks out, and the user is presented with a file picker asking where to save the receipt file. Cancelling this file picker cancels the checkout process, ensuring that no receipt file is written, the cart is not emptied, and the items have not been removed from the filestore

8. Receipt files consist of a series of entry rows showing the items ordered, and a final total cost. Each item entry row includes the product name, quantity, total cost, and unit cost.

10. Receipt rows are formatted in a columnar fashion, with all items neatly lining up between rows.
