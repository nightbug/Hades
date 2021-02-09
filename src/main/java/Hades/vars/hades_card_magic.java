package Hades.vars;

import Hades.cards.abs.abs_hades_card;
import basemod.abstracts.DynamicVariable;
import com.megacrit.cardcrawl.cards.AbstractCard;

import static Hades.Hades.makeID;


public class hades_card_magic extends DynamicVariable {

    @Override
    public String key() { return makeID("M"); }
    //TODO: Change this, if you want. It's already modID prefixed, so no worries about conflicts (ASSUMING YOU CHANGED YOUR MODID!)

    @Override
    public boolean isModified(AbstractCard card) {
        if (card instanceof abs_hades_card) {
            return ((abs_hades_card) card).isHADESSecondMagicNumberModified;
        }
        return false;
    }

    @Override
    public int value(AbstractCard card) {
        if (card instanceof abs_hades_card) {
            return ((abs_hades_card) card).hadesSecondMagicNumber;
        }
        return -1;
    }

    public void setIsModified(AbstractCard card, boolean v) {
        if (card instanceof abs_hades_card) {
            ((abs_hades_card) card).isHADESSecondMagicNumberModified = v;
        }
    }

    @Override
    public int baseValue(AbstractCard card) {
        if (card instanceof abs_hades_card) {
            return ((abs_hades_card) card).hadesBaseSecondMagicNumber;
        }
        return -1;
    }

    @Override
    public boolean upgraded(AbstractCard card) {
        if (card instanceof abs_hades_card) {
            return ((abs_hades_card) card).upgradedHADESSecondMagicNumber;
        }
        return false;
    }
}