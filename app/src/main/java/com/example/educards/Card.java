package com.example.educards;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Card", foreignKeys = @ForeignKey(
        entity = CardsSelection.class,
        parentColumns = "CardsSelection_id",
        childColumns = "SelectionId",
        onDelete = ForeignKey.CASCADE
))
public class Card {

    @ColumnInfo(name="Card_id")
    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name="Concept")
    String сoncept;

    @ColumnInfo(name="Explanation")
    String Explanation;

    @ColumnInfo(name="KnowledgeLevel")
    int KnowledgeLevel;

    @ColumnInfo(name="SelectionId")
    int SelectionId;

    @Ignore
    public Card(){}

    public Card(String concept, String explanation, int knowledgeLevel, int selectionId) {
        Concept = concept;
        Explanation = explanation;
        KnowledgeLevel = knowledgeLevel;
        SelectionId = selectionId;
    }

    public String getConcept() {
        return сoncept;
    }

    public void setConcept(String concept) {
        сoncept = concept;
    }

    public String getExplanation() {
        return Explanation;
    }

    public void setExplanation(String explanation) {
        Explanation = explanation;
    }

    public int getKnowledgeLevel() {
        return KnowledgeLevel;
    }

    public void setKnowledgeLevel(int knowledgeLevel) {
        KnowledgeLevel = knowledgeLevel;
    }
}
