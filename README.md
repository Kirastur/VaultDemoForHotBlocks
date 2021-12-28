# VaultDemoForHotBlocks
This is a Demo for HotBlocks to demonstrate how you can use the HotBlocks Events to award the player with ingame money when they trigger a block.

To keep things simple we use Vault as Gateway to the Economy provider.

Install the HotBlocks plugin from https://www.spigotmc.org/resources/hotblocks-mechanic.93691

This demo requires the two demo rules from the out-of-the-box HotBlocks plugin.yml

To watch the demo, do the following (this example is based on "The New Economy" as Economy system):
1. Install "Vault" and "The New Economy"
2. Login to the server and query your balance ("/tne balance <playername>")
3. Enter "/hotblocks enable world" to enable Hotblocks for the normal world
4. Place a "Blue Concrete" Block on the ground
5. Jump on top of this block. As a result the blue block must change its color to red.
6. Query your balance again ("/tne balance <playername>"). You should have one dollar more.
