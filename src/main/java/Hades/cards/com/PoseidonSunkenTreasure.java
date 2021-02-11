package Hades.cards.com;

import Hades.cards.abs.abs_hades_card;
import Hades.enums.hadesCards;
import Hades.util.CardInfo;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

import static Hades.Hades.makeID;
import static Hades.util.actionShortcuts.*;

public class PoseidonSunkenTreasure extends abs_hades_card {
    private final static CardInfo cardInfo = new CardInfo(
            PoseidonSunkenTreasure.class.getSimpleName(),
            COSTS[2],
            AbstractCard.CardType.SKILL,
            AbstractCard.CardTarget.SELF
    );
    public static final String ID = makeID(cardInfo.cardName);
    private static final int STR_DEX = 1;
    private static final int HP = 2;
    private static final int UPG_HP = 3;
    public PoseidonSunkenTreasure() {
        super(cardInfo, false);
        setMagic(STR_DEX);
        setHadesMagic(HP, UPG_HP);
        this.tags.add(hadesCards.POSEIDON);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        doPow(p, new StrengthPower(p, magicNumber));
        doPow(p, new DexterityPower(p, magicNumber));
        atb(new HealAction(p, p, hadesSecondMagicNumber));
    }
}
