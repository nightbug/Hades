package Hades.cards.rar;

import Hades.cards.abs.abs_hades_card;
import Hades.enums.hadesCards;
import Hades.util.CardInfo;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.AttackDamageRandomEnemyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static Hades.Hades.makeID;
import static Hades.util.actionShortcuts.atb;

public class AresAid extends abs_hades_card {
    private final static CardInfo cardInfo = new CardInfo(
            AresAid.class.getSimpleName(),
            COSTS[4],
            AbstractCard.CardType.ATTACK,
            CardTarget.ALL_ENEMY
    );
    public static final String ID = makeID(cardInfo.cardName);
    private static final int DMG = 1;
    private static final int UPG_DMG = 2;

    private static final int HITS = 1;
    private static final int UPG_HITS = 1;
    public AresAid() {
        super(cardInfo, true);
        setDamage(DMG, UPG_DMG);
        setMagic(HITS, UPG_HITS);
        tags.add(hadesCards.ARES);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        for(int i = 0; i < magicNumber; i += 1){ atb(new AttackDamageRandomEnemyAction(this, AbstractGameAction.AttackEffect.NONE)); }
    }
    public void applyPowers(){
        super.applyPowers();
        int realMagicNumber = this.baseMagicNumber;
        this.magicNumber = realMagicNumber + countAresCards();
        this.isMagicNumberModified = (this.magicNumber != this.baseMagicNumber);
        rawDescription = cardStrings.DESCRIPTION;
        if(magicNumber > 1){ rawDescription += cardStrings.UPGRADE_DESCRIPTION; }
        this.initializeDescription();
    }

    public static int countAresCards(){
        int count = 0;
        for (AbstractCard c : AbstractDungeon.actionManager.cardsPlayedThisCombat) {
            if (c.hasTag(hadesCards.ARES)) { count++; }
        }
        return count;
    }
}