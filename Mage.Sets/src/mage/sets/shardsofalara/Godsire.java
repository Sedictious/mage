/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */

package mage.sets.shardsofalara;

import java.util.UUID;

import mage.Constants;
import mage.Constants.CardType;
import mage.Constants.Rarity;
import mage.MageInt;
import mage.ObjectColor;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.common.TapSourceCost;
import mage.abilities.effects.common.CreateTokenEffect;
import mage.abilities.keyword.VigilanceAbility;
import mage.cards.CardImpl;
import mage.game.permanent.token.Token;

/**
 *
 * @author Loki
 */
public class Godsire extends CardImpl<Godsire> {

    public Godsire (UUID ownerId) {
        super(ownerId, 170, "Godsire", Rarity.MYTHIC, new CardType[]{CardType.CREATURE}, "{4}{R}{G}{G}{W}");
        this.expansionSetCode = "ALA";
        this.subtype.add("Beast");
		this.color.setRed(true);
		this.color.setGreen(true);
		this.color.setWhite(true);
        this.power = new MageInt(8);
        this.toughness = new MageInt(8);
		this.addAbility(VigilanceAbility.getInstance());
		this.addAbility(new SimpleActivatedAbility(Constants.Zone.BATTLEFIELD, new CreateTokenEffect(new BeastToken()), new TapSourceCost()));
    }

    public Godsire (final Godsire card) {
        super(card);
    }

    @Override
    public Godsire copy() {
        return new Godsire(this);
    }

}

class BeastToken extends Token {
	BeastToken() {
		super("Beast", "an 8/8 Beast creature token that's red, green, and white");
		cardType.add(CardType.CREATURE);
		color.setGreen(true);
		color.setWhite(true);
		color.setRed(true);
		subtype.add("Beast");
		power = new MageInt(8);
		toughness = new MageInt(8);
	}
}