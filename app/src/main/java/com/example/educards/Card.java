package com.example.educards;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "Card", foreignKeys = @ForeignKey(
        entity = CardsSelection.class,
        parentColumns = "CardsSelection_id",
        childColumns = "SelectionId",
        onDelete = ForeignKey.CASCADE),
        indices = @Index(value = "SelectionId")
)
public class Card {

    @ColumnInfo(name="Card_id")
    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name="Concept")
    String concept;

    @ColumnInfo(name="Explanation")
    String explanation;

    @ColumnInfo(name="KnowledgeLevel")
    int knowledgeLevel;

    @ColumnInfo(name="SelectionId")
    int selectionId;

    @Ignore
    public Card(){}

    public Card(String concept, String explanation, int knowledgeLevel, int selectionId) {
        this.concept = concept;
        this.explanation = explanation;
        this.knowledgeLevel = knowledgeLevel;
        this.selectionId = selectionId;
    }

    public String getConcept() {
        return this.concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public String getExplanation() {
        return this.explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public int getKnowledgeLevel() {
        return this.knowledgeLevel;
    }

    public void setKnowledgeLevel(int knowledgeLevel) {
        this.knowledgeLevel = knowledgeLevel;
    }
}
