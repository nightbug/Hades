package Hades.cards.rar;

import Hades.cards.abs.abs_hades_card;
import Hades.enums.hadesCards;
import Hades.util.CardInfo;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static Hades.Hades.makeID;
import static Hades.util.actionShortcuts.doDef;

public class PoseidonAid extends abs_hades_card {
    private final static CardInfo cardInfo = new CardInfo(
            PoseidonAid.class.getSimpleName(),
            COSTS[3],
            CardType.SKILL,
            CardTarget.SELF
    );
    public static final String ID = makeID(cardInfo.cardName);
    private static final int BLOCK = 2;
    private static final int UPG_BLOCK = 2;
    private static final int HITS = 1;
    public PoseidonAid() {
        super(cardInfo, false);
        setBlock(BLOCK, UPG_BLOCK);
        setMagic(HITS);
        tags.add(hadesCards.POSEIDON);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        for(int i = 0; i < magicNumber; i += 1){ doDef(block); }
    }
    public void applyPowers(){
        super.applyPowers();
        int realMagicNumber = this.baseMagicNumber;
        this.magicNumber = realMagicNumber + countPoseidonCards();
        this.isMagicNumberModified = (this.magicNumber != this.baseMagicNumber);
        rawDescription = cardStrings.DESCRIPTION;
        if(magicNumber > 1){ rawDescription += cardStrings.UPGRADE_DESCRIPTION; }
        this.initializeDescription();
    }

    public static int countPoseidonCards(){
        int count = 0;
        for (AbstractCard c : AbstractDungeon.actionManager.cardsPlayedThisCombat) {
            if (c.hasTag(hadesCards.POSEIDON)) { count++; }
        }
        return count;
    }
}