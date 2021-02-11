package Hades.cards.com;

import Hades.cards.abs.abs_hades_card;
import Hades.enums.hadesCards;
import Hades.util.CardInfo;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;

import static Hades.Hades.makeID;
import static Hades.util.actionShortcuts.doDmg;
import static Hades.util.actionShortcuts.doPow;

public class DionysusDrunkenStrike extends abs_hades_card {
    private final static CardInfo cardInfo = new CardInfo(
            DionysusDrunkenStrike.class.getSimpleName(),
            COSTS[1],
            CardType.ATTACK,
            CardTarget.ENEMY
    );
    public static final String ID = makeID(cardInfo.cardName);
    private static final int DAMAGE = 8;
    private static final int UPG_DAMAGE = 3;
    private static final int HITS = 2;
    private static final int UPG_HITS = 1;
    public DionysusDrunkenStrike() {
        super(cardInfo, false);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(HITS, UPG_HITS);
        this.tags.add(hadesCards.DIONYSUS);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        for(int i = 0; i < magicNumber; i+= 1){ doDmg(m, damage); }
    }
}
