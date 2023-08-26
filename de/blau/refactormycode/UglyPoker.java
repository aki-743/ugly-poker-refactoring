package de.blau.refactormycode;

import java.util.Arrays;
import java.util.Comparator;

public class UglyPoker {
	private Deck myDeck;

	private class Card {
		private Suit suit;
		private int number;

		private enum Suit {
			Heart("h"),
			Diamond("d"),
			Spade("s"),
			Club("c");

			private String suit;

			private Suit(String suit) {
				this.suit = suit;
			}

			private String getSuit() {
				return this.suit;
			}

			private static Suit getSuitByStringSuit(String suit) {
				Suit _suit = Suit.Heart;
				for (Suit s : Suit.values()) {
					if (s.getSuit().equals(suit)) {
							_suit = s;
					}
				}
				return _suit;
			}
		}

		private Card(String p) {
			this.suit = Suit.getSuitByStringSuit(p.substring(0, 1));
			this.number = Integer.valueOf(p.substring(1));
		}
	}

	private class Deck implements Comparable<Deck> {
		private Card[] cards;

		private Deck(String p1, String p2, String p3, String p4, String p5) {
			this.cards = new Card[]{
				new Card(p1),
				new Card(p2),
				new Card(p3),
				new Card(p4),
				new Card(p5)
			};
		}

		@Override
		public int compareTo(Deck deck) {
			// カードを数字の降順でソートします
			Arrays.sort(this.cards, Comparator.comparingInt(card -> card.number));
			Arrays.sort(deck.cards, Comparator.comparingInt(card -> card.number));
			
			return Integer.compare(this.cards[4].number, deck.cards[4].number);
		}
	}

	public UglyPoker(String p1, String p2, String p3, String p4, String p5) {
		this.myDeck = new Deck(p1, p2, p3, p4, p5);
	}

	public int compareHighCard(String p1, String p2, String p3, String p4, String p5) {
		Deck opponentDeck = new Deck(p1, p2, p3, p4, p5);

		return this.myDeck.compareTo(opponentDeck);
	}
}