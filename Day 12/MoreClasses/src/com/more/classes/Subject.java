package com.more.classes;

public class Subject
{
    private String subjectCode;
    private String subjectName;

    public Subject(String subjectCode, String subjectName)
    {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
    }

    public Subject(Subject subject)
    {
        this.subjectCode = subject.subjectCode;
        this.subjectName = subject.subjectName;
    }

    public boolean equals(Subject other)
    {
        return ( this.subjectCode.equals(other.subjectCode) && this.subjectName.equals(other.subjectName) );
    }

    public String getSubjectCode()
    {
        return subjectCode;
    }

    public String getSubjectName()
    {
        return subjectName;
    }

    public void setSubjectName(String subjectName)
    {
        this.subjectName = subjectName;
    }

    @Override
    public String toString()
    {
        return "Subject Information:\n" + "Subject Code: " + this.subjectCode + "\n" + "Subject Name: " + this.subjectName;
    }
}
