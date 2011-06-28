package mage.interfaces.plugin;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.swing.JComponent;

import mage.cards.Card;
import mage.cards.CardDimensions;
import mage.cards.MagePermanent;
import mage.cards.action.ActionCallback;
import mage.view.CardView;
import mage.view.PermanentView;
import net.xeoh.plugins.base.Plugin;

/**
 * Interface for card plugins
 * 
 * @version 0.3 21.11.2010 #getMageCard
 * @version 0.2 07.11.2010 #downloadImages
 * @version 0.1 31.10.2010 #getMagePermanent, #sortPermanents
 * @author nantuko
 */
public interface CardPlugin extends Plugin {
	MagePermanent getMagePermanent(PermanentView permanent, Dimension dimension, UUID gameId, ActionCallback callback, boolean canBeFoil, boolean loadImage);
	MagePermanent getMageCard(CardView permanent, Dimension dimension, UUID gameId, ActionCallback callback, boolean canBeFoil, boolean loadImage);
	void sortPermanents(Map<String, JComponent> ui, Collection<MagePermanent> cards);

    /**
     * Download images.
     *
     * @param allCards Set of cards to download images for.
     * @param imagesPath Path to check in and store images to. Can be null, in such case default path should be used.
     */
    void downloadImages(Set<Card> allCards, String imagesPath);

    /**
     * Download various symbols (mana, tap, set).
     *
     * @param imagesPath Path to check in and store symbols to. Can be null, in such case default path should be used.
     */
	void downloadSymbols(String imagesPath);

	Image getManaSymbolImage(String symbol);
	void onAddCard(MagePermanent card, int count);
	void onRemoveCard(MagePermanent card, int count);
    JComponent getCardInfoPane();
	BufferedImage getOriginalImage(CardView card);
}
