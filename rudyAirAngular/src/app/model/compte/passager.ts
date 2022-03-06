export class Passager {
  private _id: number | undefined;
  private _nom: string | undefined;
  private _prenom: string | undefined;
  private _dateDeNaissance: Date | undefined;

  constructor(id: number, nom: string, prenom: string, dateDeNaissance: Date) {
    this._id = id;
    this._nom = nom;
    this._prenom = prenom;
    this._dateDeNaissance = dateDeNaissance;
  }

  /**
   * Getter id
   * @return {number }
   */
  public get id(): number | undefined {
    return this._id;
  }

  /**
   * Getter nom
   * @return {string }
   */
  public get nom(): string | undefined {
    return this._nom;
  }

  /**
   * Getter prenom
   * @return {string }
   */
  public get prenom(): string | undefined {
    return this._prenom;
  }

  /**
   * Getter dateDeNaissance
   * @return {Date }
   */
  public get dateDeNaissance(): Date | undefined {
    return this._dateDeNaissance;
  }

  /**
   * Setter id
   * @param {number } value
   */
  public set id(value: number | undefined) {
    this._id = value;
  }

  /**
   * Setter nom
   * @param {string } value
   */
  public set nom(value: string | undefined) {
    this._nom = value;
  }

  /**
   * Setter prenom
   * @param {string } value
   */
  public set prenom(value: string | undefined) {
    this._prenom = value;
  }

  /**
   * Setter dateDeNaissance
   * @param {Date } value
   */
  public set dateDeNaissance(value: Date | undefined) {
    this._dateDeNaissance = value;
  }
}
